package com.chemcool.school.apigateway.configuration.swagger;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@Component
public class SwaggerResourcesFilter extends ZuulFilter {

    private final DiscoveryClient discoveryClient;

    public SwaggerResourcesFilter(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        String uri = RequestContext.getCurrentContext().getRequest().getRequestURI();
        return discoveryClient.getServices().stream().map(service -> "/" + service + "/v2/api-docs")
                .anyMatch(x -> x.equals(uri));
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String uri = context.getRequest().getRequestURI();
        try (InputStream stream = context.getResponseDataStream()) {
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(body);
            jsonObject.getJSONArray("tags").remove(jsonObject.getJSONArray("tags").get(0));
            jsonObject.getJSONObject("paths").remove(uri.substring(0, uri.length() - 11) + "error");
            jsonObject.getJSONObject("definitions").remove("View");
            jsonObject.getJSONObject("definitions").remove("ModelAndView");
            body = jsonObject.toString();
            context.setResponseDataStream(new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            throw new ZuulException(e, INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
        return null;
    }
}
