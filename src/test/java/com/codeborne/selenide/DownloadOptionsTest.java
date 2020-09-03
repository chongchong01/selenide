package com.codeborne.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.files.FileFilters.none;
import static com.codeborne.selenide.files.FileFilters.withExtension;
import static org.assertj.core.api.Assertions.assertThat;

class DownloadOptionsTest {
  @Test
  void defaultOptions() {
    DownloadOptions options = using(PROXY);

    assertThat(options.method()).isEqualTo(PROXY);
    assertThat(options.timeout()).isEqualTo(-1);
    assertThat(options.filter()).isEqualTo(none());
  }

  @Test
  void customTimeout() {
    DownloadOptions options = using(PROXY).timeout(9999);

    assertThat(options.method()).isEqualTo(PROXY);
    assertThat(options.timeout()).isEqualTo(9999);
    assertThat(options.filter()).isEqualTo(none());
  }

  @Test
  void customFileFilter() {
    DownloadOptions options = using(FOLDER).filter(withExtension("pdf"));

    assertThat(options.method()).isEqualTo(FOLDER);
    assertThat(options.timeout()).isEqualTo(-1);
    assertThat(options.filter()).usingRecursiveComparison().isEqualTo(withExtension("pdf"));
  }

  @Test
  void customSettings() {
    DownloadOptions options = using(FOLDER).filter(withExtension("ppt")).timeout(1234);

    assertThat(options.method()).isEqualTo(FOLDER);
    assertThat(options.timeout()).isEqualTo(1234);
    assertThat(options.filter()).usingRecursiveComparison().isEqualTo(withExtension("ppt"));
  }
}
