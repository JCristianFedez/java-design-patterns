package com.cristian.design.patterns;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VideoResource {

  private final FieldJsonMapper fieldJsonMapper;

  private final Map<Integer, Video> videos;

  public String getDetails(final int id, final String... fields) throws Exception {
    if (fields.length == 0) {
      return this.videos.get(id).toString();
    }
    return this.fieldJsonMapper.toJson(this.videos.get(id), fields);
  }
}
