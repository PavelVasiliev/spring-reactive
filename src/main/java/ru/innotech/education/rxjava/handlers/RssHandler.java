package ru.innotech.education.rxjava.handlers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.innotech.education.rxjava.models.ErrorResponse;
import ru.innotech.education.rxjava.models.Item;
import ru.innotech.education.rxjava.models.SubscriptionRequest;

@Tag(name = "RSS operations")
@Service
@RequiredArgsConstructor
public class RssHandler {
    private final WebClient webClient;

    @NotNull
    @Operation(
            summary = "Subscribe to RSS feed",
            requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = SubscriptionRequest.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parsed data from RSS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Item.class)))),
                    @ApiResponse(responseCode = "409", description = "RSS already exists", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    public Mono<ServerResponse> subscribe(@NotNull ServerRequest request) {
        return Mono.error(NotImplementedException::new);
    }

    @NotNull
    @Operation(
            summary = "Get updates for RSS feed",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parsed data from RSS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Item.class)))),
                    @ApiResponse(responseCode = "404", description = "RSS not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    public Mono<ServerResponse> updates(@NotNull ServerRequest request) {
        return Mono.error(NotImplementedException::new);
    }

    @NotNull
    @Operation(
            summary = "Unsubscribe from RSS feed",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Successfully unsubscribed", content = @Content()),
                    @ApiResponse(responseCode = "404", description = "RSS not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    public Mono<ServerResponse> unsubscribe(@NotNull ServerRequest request) {
        return Mono.error(NotImplementedException::new);
    }
}
