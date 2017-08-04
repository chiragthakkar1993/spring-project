package com.digit.rest;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.digit.DAO.ActivityDAO;
import com.digit.models.Activity;

@Path("/ActivityService")
public class ActivityService {

	@GET
	@Path("/Activities/{activityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getActivity(@PathParam("activityId") long activityId) {

		ActivityDAO activityDAO = new ActivityDAO();
		System.out.println("get Activity called");
		return activityDAO.getActivity(activityId);

	}

	@PUT
	@Path("/Activities")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateActivity(@FormParam("updateactivityobj") String activityId) {

		Activity act = new Activity();

		System.out.println("update activity called");

		// System.out.println("Status:
		// "+Response.status(200).build().getStatus());

		return Response.status(200).entity("Record Updated Successfully").build();

	}

	@POST
	@Path("/Activities")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Activity createActivity(@FormParam("createactivityobj") String activityId) {

		Activity act = new Activity();

		System.out.println("Create activity called");

		return act;

	}

}
