package kr.joberchip.server.v1.share.block.controller;

import java.util.UUID;
import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.share.block.controller.dto.VideoBlockDTO;
import kr.joberchip.server.v1.share.block.service.VideoBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/page/{pageId}/videoBlock")
public class VideoBlockController {

  private final VideoBlockService videoBlockService;

  @PostMapping
  public ApiResponse.Result<Object> createVideoBlock(
      @PathVariable UUID pageId, @RequestParam VideoBlockDTO videoBlockDTO) {

    videoBlockService.uploadVideo(videoBlockDTO);
    videoBlockService.createVideoBlock(pageId, videoBlockDTO);

    return ApiResponse.success();
  }

  @PutMapping("/{blockId}")
  public ApiResponse.Result<Object> modifyVideoBlock(
      @PathVariable UUID pageId,
      @PathVariable UUID blockId,
      @RequestBody VideoBlockDTO videoBlockDTO) {

    videoBlockService.modifyVideoBlock(pageId, blockId, videoBlockDTO);

    return ApiResponse.success();
  }

  @DeleteMapping("/{blockId}")
  public ApiResponse.Result<Object> deleteVideoBlock(
      @PathVariable UUID pageId, @PathVariable UUID blockId) {

    videoBlockService.deleteVideoBlock(pageId, blockId);

    return ApiResponse.success();
  }
}
