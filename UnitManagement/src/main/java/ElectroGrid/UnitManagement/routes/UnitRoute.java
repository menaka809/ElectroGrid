package ElectroGrid.UnitManagement.routes;

import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ElectroGrid.UnitManagement.controller.UnitController;
import ElectroGrid.UnitManagement.modal.Unit;

@Path("unitInformation")
public class UnitRoute {
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUsageInformation() throws ClassNotFoundException, SQLException{
//    	System.out.println(UserUsageInformationController.getUserUsageInformation());
//		return Response.status(Status.OK).entity(UserUsageInformationController.getUserUsageInformation()).build();
    	if(UnitController.getUnitInformation().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Unit Informations found").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(UnitController.getUnitInformation()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUserUsageInformation(Unit unit) throws ClassNotFoundException, SQLException {
    	 System.out.println(unit);
    	 Unit createUnitInformation = UnitController.createUnitInformation(unit);
    	 if(createUnitInformation  != null) {
    		 return Response.status(Status.CREATED).entity(createUnitInformation ).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUnitInformationByID(@PathParam("id") int unId) throws ClassNotFoundException, SQLException{
    	
    	if(UnitController.getUnitInformationByID(unId) != null) {
    		return Response.status(Status.OK).entity(UnitController.getUnitInformationByID(unId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Unit Informations found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserUsageInformation(Unit unit,@PathParam("id") int unId) throws ClassNotFoundException, SQLException {
		
		if(unit != null) {
			if(UnitController.updateUnitInformation(unit,unId) != null) {
				return Response.status(Status.OK).entity(UnitController.updateUnitInformation(unit,unId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related unit Informations found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserUsageInformation(@PathParam("id") int unId) throws ClassNotFoundException, SQLException{
		 
		if(!UnitController.deleteUnitInformation(unId)) {
			return Response.status(Status.OK).entity( unId + " " + "deleted successfully" ).build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
//"Unit details " + unitsId +" "+ "deleted successfully"