package resource;

import model.User;
import repository.Impl.UserRepositoryImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@WebServlet("/api/users")
public class UserResource extends HttpServlet {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUsers() {
        List<User> users = userRepository.getAll();
        GenericEntity<List<User>> entity = new GenericEntity<>(users) {
        };

        return Response
                .ok(entity)
                .build();
    }

    @GET
    @Path("/{id}")
    //@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUser(@PathParam("id") Integer id) {
        User user = userRepository.getById(id);

        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return Response
                .ok(user)
                .build();
    }

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(User user) {
        if (userRepository.save(user) == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response
                .ok(user)
                .build();
    }

    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateUser(User user) {
        userRepository.update(user);
        return Response
                .ok(user)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteUser(@PathParam("id") Integer id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.deleteById(id);

            return Response
                    .ok(user)
                    .build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
