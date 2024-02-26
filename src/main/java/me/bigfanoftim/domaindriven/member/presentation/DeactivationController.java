package me.bigfanoftim.domaindriven.member.presentation;

import me.bigfanoftim.domaindriven.member.application.DeactivationService;
import me.bigfanoftim.domaindriven.member.presentation.dto.DeactivateMemberRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeactivationController {

    private final DeactivationService deactivationService;

    public DeactivationController(DeactivationService deactivationService) {
        this.deactivationService = deactivationService;
    }

    @PostMapping("/members/deactivate")
    public void deactivate(@RequestBody DeactivateMemberRequest request) {
        deactivationService.deactivate(request.getMemberId());
    }
}
