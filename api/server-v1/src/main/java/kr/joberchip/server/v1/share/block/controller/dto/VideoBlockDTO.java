package kr.joberchip.server.v1.share.block.controller.dto;

import kr.joberchip.core.share.block.VideoBlock;
import org.springframework.web.multipart.MultipartFile;

public record VideoBlockDTO(
    String title, String description, String videoLink, MultipartFile videoFile) {

  public VideoBlock toEntity() {
    if ("".equals(videoLink)) return VideoBlock.of(title, description);

    return VideoBlock.of(title, description, videoLink);
  }
}
