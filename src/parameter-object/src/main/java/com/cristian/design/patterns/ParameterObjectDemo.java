package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParameterObjectDemo {

  public static void main(String[] args) {
    final SearchService.ParameterObject params = SearchService.ParameterObject.builder()
        .withType("sneakers")
        .sortBy("brand")
        .build();
    LOGGER.info(params.toString());
    LOGGER.info(new SearchService().search(params));
  }
}
