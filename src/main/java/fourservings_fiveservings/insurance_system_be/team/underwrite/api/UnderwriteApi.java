package fourservings_fiveservings.insurance_system_be.team.underwrite.api;

import fourservings_fiveservings.insurance_system_be.auth.custom.CustomUserDetails;
import fourservings_fiveservings.insurance_system_be.common.response.vo.ApiResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/underwrite", produces = "application/json;charset=utf-8")
public interface UnderwriteApi {

    @PatchMapping("/{productId}")
    ApiResponse<?> approveProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails,
        @PathVariable(name = "productId") Long productId);
}
