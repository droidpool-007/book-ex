package com.bookex.utils.server;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServerApi {

  String FORCE_UPDATE = "/device_version/is_force_update/platform/printer/version_code/{version_code}.json";

  @GET(FORCE_UPDATE)
  void isForceUpdate(@Path("version_code") int version_code);
}
