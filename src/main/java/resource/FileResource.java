package resource;

import controller.FileController;
import model.File;
import repository.Impl.FileRepositoryImpl;
import service.FileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/files")
public class FileResource {

    private final FileController fileController = new FileController(new FileService(new FileRepositoryImpl()));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<File> list() {
        return fileController.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        File file = fileController.getById(id);

        if (file == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return Response
                .ok(file)
                .build();
    }

    @POST
    @Path("/create")
    public Response createUser(File file) {
        if (fileController.save(file) == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response
                .ok(file)
                .build();
    }

    @PUT
    @Path("/update")
    public Response updateUser(File file) {
        fileController.update(file);
        return Response
                .ok(file)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        File file = fileController.getById(id);
        if (file != null) {
            fileController.deleteById(id);

            return Response
                    .ok(file)
                    .build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}
