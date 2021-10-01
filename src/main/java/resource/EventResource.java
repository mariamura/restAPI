package resource;

import controller.EventController;
import model.Event;
import repository.Impl.EventRepositoryImpl;
import service.EventService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/events")
public class EventResource {

    private final EventController eventController = new EventController(new EventService(new EventRepositoryImpl()));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> list() {
        return eventController.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        Event event = eventController.getById(id);

        if (event == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return Response
                .ok(event)
                .build();
    }

    @POST
    @Path("/create")
    public Response createUser(Event event) {
        if (eventController.save(event) == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response
                .ok(event)
                .build();
    }

    @PUT
    @Path("/update")
    public Response updateUser(Event event) {
        eventController.update(event);
        return Response
                .ok(event)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        Event event = eventController.getById(id);
        if (event != null) {
            eventController.deleteById(id);

            return Response
                    .ok(event)
                    .build();
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}
