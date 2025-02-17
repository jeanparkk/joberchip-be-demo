package kr.joberchip.server.v1.share.block.controller;

import java.util.UUID;
import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.share.block.controller.dto.LinkBlockDTO;
import kr.joberchip.server.v1.share.block.service.LinkBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/page")
public class LinkBlockController {
  private final LinkBlockService linkBlockService;

  @PostMapping("/{pageId}/linkBlock")
  public ApiResponse.Result<Object> createLinkBlock(
          @PathVariable UUID pageId,
          @RequestBody @Valid LinkBlockDTO.Create newLinkBlock,
          Errors errors) {
    linkBlockService.createLinkBlock(pageId, newLinkBlock);
    return ApiResponse.success();
  }

  @PutMapping("/linkBlock/{blockId}")
  public ApiResponse.Result<Object> modifyLinkBlock(
      @PathVariable UUID blockId,
      @RequestBody LinkBlockDTO.Modify modifiedLinkBlock) {
    linkBlockService.modifyLinkBlock(blockId, modifiedLinkBlock);
    return ApiResponse.success();
  }

  @GetMapping("/linkBlock/{blockId}")
  public ApiResponse.Result<Object> changeVisible(@PathVariable UUID blockId) {
    return ApiResponse.success(linkBlockService.changeVisible(blockId));
  }

  @DeleteMapping("/linkBlock/{blockId}")
  public ApiResponse.Result<Object> deleteLinkBlock(@PathVariable UUID blockId) {
    linkBlockService.deleteLinkBlock(blockId);
    return ApiResponse.success();
  }
}
