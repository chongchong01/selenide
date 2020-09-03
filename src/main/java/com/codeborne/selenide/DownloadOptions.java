package com.codeborne.selenide;

import com.codeborne.selenide.files.FileFilter;

import static com.codeborne.selenide.files.FileFilters.none;

public class DownloadOptions {
  private final FileDownloadMode method;
  private final long timeout;
  private final FileFilter filter;

  private DownloadOptions(FileDownloadMode method, long timeout, FileFilter filter) {
    this.method = method;
    this.timeout = timeout;
    this.filter = filter;
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
    return new DownloadOptions(method, timeout, filter);
  }

  public DownloadOptions filter(FileFilter filter) {
    return new DownloadOptions(method, timeout, filter);
  }

  @Override
  public String toString() {
    return String.format("method=%s, timeout=%s ms, filter='%s'", method, timeout, filter.description());
  }

  public static DownloadOptions using(FileDownloadMode method) {
    return new DownloadOptions(method, -1, none());
  }
}
