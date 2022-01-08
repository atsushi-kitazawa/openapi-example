package org.openapitools.api;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/users")
@Api(description = "the users API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-01-08T23:32:17.077+09:00[Asia/Tokyo]")public class UsersApi {

    @GET
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Returns a list of users.", notes = "Optional extended description in CommonMark or HTML.", response = String.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A JSON array of user names", response = String.class, responseContainer = "List")
    })
    public Response usersGet() {
        List<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("bar");
        return Response.ok().entity(list).build();
    }
}
