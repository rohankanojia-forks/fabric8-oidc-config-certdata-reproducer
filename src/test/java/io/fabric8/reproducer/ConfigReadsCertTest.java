package io.fabric8.reproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigReadsCertTest {
  @Test
  void configLoadsCertData() throws JsonProcessingException {
    // Given
    Config config = new ConfigBuilder().build();
    // When + Then
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(config));
    assertNotNull(config.getCaCertFile());
    assertNotNull(config.getMasterUrl());
//    assertNotNull(config.getCaCertData());
  }
}
