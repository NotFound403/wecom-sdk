/*
 * Copyright (c) 2024. felord.cn
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://www.apache.org/licenses/LICENSE-2.0
 * Website:
 *       https://felord.cn
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.felord.retrofit.ssl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;

/**
 * Ssl manager.
 *
 * @author dax
 * @since 2024/6/27
 */
public class SSLManager {
    private final X509TrustManager trustManager;
    private final SSLSocketFactory sslSocketFactory;

    /**
     * Instantiates a new Ssl manager.
     *
     * @param pkcs12InputStream the pkcs 12 input stream
     * @param pin               the pin
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws KeyStoreException        the key store exception
     * @throws KeyManagementException   the key management exception
     * @throws CertificateException     the certificate exception
     * @throws IOException              the io exception
     */
    public SSLManager(InputStream pkcs12InputStream, String pin) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, CertificateException, IOException {
        KeyStore store = KeyStore.getInstance("PKCS12");
        store.load(pkcs12InputStream, pin.toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(store);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:"
                    + Arrays.toString(trustManagers));
        }
        SSLContext tlSv1 = SSLContext.getInstance("TLSv1");
        X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
        tlSv1.init(null, new TrustManager[]{x509TrustManager}, null);
        this.trustManager = x509TrustManager;
        this.sslSocketFactory = tlSv1.getSocketFactory();
    }

    /**
     * Instantiates a new Ssl manager.
     *
     * @param loadedKeyStore the loadedKey store
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws KeyStoreException        the key store exception
     * @throws KeyManagementException   the key management exception
     */
    public SSLManager(KeyStore loadedKeyStore) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(loadedKeyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:"
                    + Arrays.toString(trustManagers));
        }
        SSLContext tlSv1 = SSLContext.getInstance("TLSv1");
        X509TrustManager x509TrustManager = (X509TrustManager) trustManagers[0];
        tlSv1.init(null, new TrustManager[]{x509TrustManager}, null);
        this.trustManager = x509TrustManager;
        this.sslSocketFactory = tlSv1.getSocketFactory();
    }

    /**
     * Instantiates a new Ssl manager.
     *
     * @param trustManager the trust manager
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws KeyManagementException   the key management exception
     */
    public SSLManager(X509TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext tlSv1 = SSLContext.getInstance("TLSv1");
        tlSv1.init(null, new TrustManager[]{trustManager}, null);
        this.trustManager = trustManager;
        this.sslSocketFactory = tlSv1.getSocketFactory();
    }

    /**
     * Instantiates a new Ssl manager.
     *
     * @param trustManager     the trust manager
     * @param sslSocketFactory the ssl socket factory
     */
    @JsonCreator
    public SSLManager(@JsonProperty("trustManager") X509TrustManager trustManager, @JsonProperty("sslSocketFactory") SSLSocketFactory sslSocketFactory) {
        this.trustManager = trustManager;
        this.sslSocketFactory = sslSocketFactory;
    }

    public X509TrustManager getTrustManager() {
        return trustManager;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return sslSocketFactory;
    }
}
