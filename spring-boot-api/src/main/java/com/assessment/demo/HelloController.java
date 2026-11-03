
package com.assessment.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", "Hello from Kubernetes DevOps Assessment!",
                "application", "k8s-demo-api"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP"
        );
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "application", "k8s-demo-api",
                "version", "1.0.0",
                "environment", "development",
                "java", "21"
        );
    }
}
