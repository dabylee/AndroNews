package com.app.andronews.retrofitconfig;

import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit retrofit = null;

    public static Retrofit getInstance(String url){

        if (retrofit == null){

            //OkHttpClient getSupportSSL;
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getSupportSSL().build())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient.Builder getSupportSSL(){
        try {
            TrustManager[] trustMNGCert = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            SSLContext sslContext1 = SSLContext.getInstance("SSL");
            sslContext1.init(null, trustMNGCert, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext1.getSocketFactory();
            OkHttpClient.Builder builder1 = new OkHttpClient.Builder();
            builder1.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustMNGCert[0]);
            builder1.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder1;

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
