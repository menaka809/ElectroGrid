package ElectroGrid.Inquiry.InquiryResourse;

import java.sql.SQLException;
import java.util.List;

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
import ElectroGrid.Inquiry.model.Inquiry;
import ElectroGrid.Inquiry.service.InquiryService;

@Path("/inquiry")
public class InquiryResourse {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Inquiry>getInquiry() throws ClassNotFoundException, SQLException{
		return InquiryService.getAllInquiry();
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Inquiry>getOneInquiry(@PathParam("id")String id) throws ClassNotFoundException, SQLException{
		return InquiryService.getOneInquiry(id);
		
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response createInquiry(Inquiry inquiry) throws ClassNotFoundException, SQLException {
		
		Inquiry createInquiry =InquiryService.createInquiry(inquiry);
		if(createInquiry!=null) {
			return Response.status(Status.CREATED).entity(createInquiry).build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInquiry(Inquiry inquiry,@PathParam("id")String id) throws ClassNotFoundException, SQLException {
		
		Inquiry updateInquiry =InquiryService.updateInquiry(inquiry,id);
		return Response.status(Status.OK).entity("Update Successfully.").build();
		}
		
		
	
	
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteInquiry(@PathParam("id")String id) throws ClassNotFoundException, SQLException {
		boolean deleteInquiry =InquiryService.deleteInquiry(id);
		if (deleteInquiry==true) {
			return Response.status(Status.OK).entity("Delete Successfully.").build();
		}else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Delete UnSuccessfully").build();
		}
		
		
	
		
	}
	
}
