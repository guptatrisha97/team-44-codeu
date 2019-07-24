package com.google.cloud.sql;

import com.google.api.client.auth.oauth2.Credential;

public interface CredentialFactory {

    /** Name of system property that can specify an alternative credential factory. */
    String CREDENTIAL_FACTORY_PROPERTY = "cloudSql.socketFactory.credentialFactory";

    Credential create();
}