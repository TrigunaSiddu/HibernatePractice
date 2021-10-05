package com.ty.hibernetdemo;

public class InavalidId extends RuntimeException{
    @Override
	public String getMessage()
	{
		return "please enter valid id";
	}
}
