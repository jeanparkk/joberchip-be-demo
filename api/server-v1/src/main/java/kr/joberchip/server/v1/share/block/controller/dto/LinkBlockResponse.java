package kr.joberchip.server.v1.share.block.controller.dto;

import kr.joberchip.core.share.block.LinkBlock;

public record LinkBlockResponse(String title, String link) {

  public static LinkBlockResponse fromEntity(LinkBlock linkBlock) {
    return new LinkBlockResponse(
        linkBlock.getTitle(), linkBlock.getLink());
  }
}
