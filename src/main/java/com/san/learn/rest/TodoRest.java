package com.san.learn.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.san.learn.annotation.Logged;
import com.san.learn.entity.Todo;
import com.san.learn.service.TodoService;

@Path("todo")
@Logged
public class TodoRest {

	@Inject
	TodoService todoService;

	@POST
	public Response createTodo(Todo todo) {
		return Response.ok(todoService.create(todo)).build();
	}

	@PUT
	public Response updateTodo(Todo todo) {
		return Response.ok(todoService.update(todo)).build();
	}

	@GET
	@Path("list")
	public Response getTodoList() {
		return Response.ok(todoService.getTodos()).build();
	}

	@GET
	@Path("{id}")
	public Response getTodoById(@PathParam("id") Long id){
		return Response.ok(todoService.findById(id)).build();
	}
}
