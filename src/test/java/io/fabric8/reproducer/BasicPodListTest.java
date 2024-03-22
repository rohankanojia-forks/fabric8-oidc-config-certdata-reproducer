package io.fabric8.reproducer;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BasicPodListTest {
  @Test
  void resolveOIDCTokenFromAuthConfig() {
    try (KubernetesClient kubernetesClient = new KubernetesClientBuilder().build()) {
      assertNotNull(kubernetesClient);
      assertNotNull(kubernetesClient.pods().list());
      kubernetesClient.pods().list().getItems().stream()
          .map(Pod::getMetadata)
          .map(ObjectMeta::getName)
          .forEach(System.out::println);
    }
  }
}
