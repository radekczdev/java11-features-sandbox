package com.example.springcrud;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_GIF;
import static org.springframework.util.MimeTypeUtils.IMAGE_GIF_VALUE;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @PostMapping(path = "/consumes-json", consumes = APPLICATION_JSON_VALUE)
  public SampleDto consumesJson(@RequestBody final SampleDto sampleDto) {
    return sampleDto;
  }

  @PostMapping(path = "/consumes-gif", consumes = IMAGE_GIF_VALUE)
  public SampleDto consumesGif(@RequestBody final SampleDto sampleDto) {
    return sampleDto;
  }

  @PostMapping(path = "/doesnt-consume-json", consumes = "!" + APPLICATION_JSON_VALUE)
  public SampleDto doesntConsumeJson(@RequestBody final SampleDto sampleDto) {
    return sampleDto;
  }
}
