package org.openapitools.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.openapitools.model.InlineResponse200;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/users")
@Api(description = "the users API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-09T11:53:45.153+09:00[Asia/Tokyo]")
public class UsersApi {

    Map<Integer, String> users = new HashMap<Integer, String>();
    
    public UsersApi() {
        users.put(1, "user1");
        users.put(2, "user2");
        users.put(3, "user3");
    }

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a list of users.", notes = "Optional extended description in CommonMark or HTML.", response = String.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A JSON array of user names", response = String.class, responseContainer = "List")
    })
    public Response usersGet() {
        Collection<String> list = users.values();
        return Response.ok().entity(list).build();
    }

    @GET
    @Path("/{userId}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Returns a user by ID.", notes = "", response = InlineResponse200.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A user object.", response = InlineResponse200.class),
            @ApiResponse(code = 400, message = "The specified user ID is invalid (not a number).", response = Void.class),
            @ApiResponse(code = 404, message = "A user with the specified ID was not found.", response = Void.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Void.class)
    })
    public Response usersUserIdGet(
            @PathParam("userId") @Min(1L) @ApiParam("The ID of the user to return.") Long userId) {

        return Response.ok().entity(new InlineResponse200().id(userId).name(users.get(userId.intValue()))).build();
    }
}
