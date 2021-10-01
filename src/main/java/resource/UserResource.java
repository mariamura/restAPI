package resource;

import controller.UserController;
import model.User;
import repository.Impl.UserRepositoryImpl;
import service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserResource {

    private final UserController userController = new UserController(new UserService(new UserRepositoryImpl()));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userController.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        User user = userController.getById(id);

        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return Response
                .ok(user)
                .build();
    }

    @POST
    @Path("/create")
    public Response createUser(User user) {
        if (userController.save(user) == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response
                .ok(user)
                .build();
    }

    @PUT
    @Path("/update")
    public Response updateUser(User user) {
        userController.update(user);
        return Response
                .ok(user)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        User user = userController.getById(id);
        if (user != null) {
            userController.deleteById(id);

            return Response
                    .ok(user)
                    .build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
