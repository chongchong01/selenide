package com.codeborne.selenide;

import com.codeborne.selenide.files.FileFilter;

import static com.codeborne.selenide.files.FileFilters.none;

public class DownloadOptions {
  private final FileDownloadMode method;
  private long timeout = -1;
  private FileFilter filter = none();

  private DownloadOptions(FileDownloadMode method) {
    this.method = method;
  }

  public FileDownloadMode method() {
    return method;
  }

  public long timeout() {
    return timeout;
  }

  public FileFilter filter() {
    return filter;
  }

  public DownloadOptions timeout(long timeout) {
    this.timeout = timeout;
    return this;
  }

  public DownloadOptions filter(FileFilter filter) {
    this.filter = filter;
    return this;
  }

  public static DownloadOptions using(FileDownloadMode method) {
    return new DownloadOptions(method);
  }
}
