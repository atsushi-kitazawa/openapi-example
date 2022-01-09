package org.openapitools.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/files")
@Api(description = "the files API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-09T11:53:45.153+09:00[Asia/Tokyo]")
public class FilesApi {

    @GET
    @Path("/download/{fileId}")
    @Produces({ "application/octet-stream", "application/json" })
    @ApiOperation(value = "", notes = "", response = File.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = File.class),
            @ApiResponse(code = 500, message = "Error", response = String.class)
    })
    public Response download(@PathParam("fileId") @ApiParam("The ID of the download file to return.") String fileId) {
        final String id = fileId;
        StreamingOutput fileStream = new StreamingOutput() {
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get(
                            "/home/atsushi/workspace/openapi/openapi-example/java-server/src/gen/java/org/openapitools/api/"
                                    + id);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename=" + fileId)
                .build();
    }

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a list of files.", notes = "Optional extended description in CommonMark or HTML.", response = String.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A JSON array of file names", response = String.class, responseContainer = "List")
    })
    public Response filesGet() {
        return Response.ok().entity("magic!").build();
    }
}
