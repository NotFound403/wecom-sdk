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

package cn.felord.payment.wechat.v3.domain.certificate;

import cn.felord.payment.PayException;
import cn.felord.payment.wechat.v3.crypto.CipherAlg;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * The type Encrypt certificate.
 *
 * @author dax
 * @since 2024/8/6
 */
@Data
public class EncryptCertificate {
    private String associatedData;
    private String ciphertext;
    private String nonce;
    private CipherAlg algorithm;

    /**
     * To x 509 certificate x 509 certificate.
     *
     * @param apiV3Secret the api v 3 secret
     * @return the x 509 certificate
     */
    public JWK toJwk(String apiV3Secret) throws PayException {
        String tenPayPublicKey = this.getAlgorithm()
                .wecomCipher()
                .decrypt(apiV3Secret, this.associatedData, this.nonce, this.ciphertext);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
            ByteArrayInputStream inputStream = new ByteArrayInputStream(tenPayPublicKey.getBytes(StandardCharsets.UTF_8));
            X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(inputStream);
            x509Certificate.checkValidity();
            return JWK.parse(x509Certificate);
        } catch (JOSEException | CertificateException e) {
            throw new PayException("Fail to get tenpay certificate", e);
        }
    }
}
