package ElectroGrid.CustomerInformationManagement.routes;

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

import ElectroGrid.CustomerInformationManagement.service.CustomerController;
import ElectroGrid.CustomerInformationManagement.modal.Customer;

@Path("customer")
public class CustomerRoute {
	@GET
	@Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUsageInformation() throws ClassNotFoundException, SQLException{
//    	System.out.println(UserUsageInformationController.getUserUsageInformation());
//		return Response.status(Status.OK).entity(UserUsageInformationController.getUserUsageInformation()).build();
    	if(CustomerController.getCustomerInformation().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Customer Informations found").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(CustomerController.getCustomerInformation()).build();
    	}
    	
	}
	
	@POST
	@Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomerInformation(Customer customer) throws ClassNotFoundException, SQLException {
    	 System.out.println(customer);
    	 Customer createCustomerInformation = CustomerController.createCustomer(customer);
    	 if(createCustomerInformation  != null) {
    		 return Response.status(Status.CREATED).entity(createCustomerInformation ).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
	
	@GET
	@Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getUserUsageInformationByID(@PathParam("id") int customerId) throws ClassNotFoundException, SQLException{
    	
    	if(CustomerController.getCustomerByID(customerId) != null) {
    		return Response.status(Status.OK).entity(CustomerController.getCustomerByID(customerId)).build();
    	}
    	else {
    		return Response.status(Status.NOT_FOUND).entity("No Related Customer Informations found").build();
    	}
    	
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCustomerInformation(Customer customer,@PathParam("id") int customerId) throws ClassNotFoundException, SQLException {
		
		if(customer != null) {
			if(CustomerController.updateCustomerInformation(customer,customerId) != null) {
				return Response.status(Status.OK).entity(CustomerController.updateCustomerInformation(customer,customerId)).build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("No Related Customer Informations found").build();
			}
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserUsageInformation(@PathParam("id") int customerId) throws ClassNotFoundException, SQLException{
		 
		if(!CustomerController.deleteCustomerInformation(customerId)) {
			return Response.status(Status.OK).entity( "Customer " + customerId +" "+ "deleted successfully").build();
		}
		else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	    	
	}

}
