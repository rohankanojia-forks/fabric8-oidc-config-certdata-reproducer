package io.fabric8.reproducer;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.okhttp.OkHttpClientFactory;
import io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OIDCTokenRefreshTest {
  @Test
  void resolveOIDCTokenFromAuthConfig() {
    // Given
    Config config = new ConfigBuilder().build();

    // When
    CompletableFuture<String> completableFuture = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, config.getAuthProvider().getConfig(), new OkHttpClientFactory().newBuilder());

    // Then
    assertTrue(completableFuture.isDone());
  }
}
