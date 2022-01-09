package org.openapitools.api;

import org.openapitools.model.InlineResponse200;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/users")
@Api(description = "the users API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-09T11:53:45.153+09:00[Asia/Tokyo]")public class UsersApi {

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a list of users.", notes = "Optional extended description in CommonMark or HTML.", response = String.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A JSON array of user names", response = String.class, responseContainer = "List")
    })
    public Response usersGet() {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{userId}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a user by ID.", notes = "", response = InlineResponse200.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A user object.", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "The specified user ID is invalid (not a number).", response = Void.class),
        @ApiResponse(code = 404, message = "A user with the specified ID was not found.", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Void.class)
    })
    public Response usersUserIdGet(@PathParam("userId") @Min(1L) @ApiParam("The ID of the user to return.") Long userId) {
        return Response.ok().entity("magic!").build();
    }
}
