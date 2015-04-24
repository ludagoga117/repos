package com.luisgoyes.practica2_p5;

import java.util.Date;
import java.util.Scanner;

public class Personal_data {
	private Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellidos;
	private int edad;
	protected int[] fechaNacimiento = {0,0,0};
	private String cedula;
	private String direccion;
	private String telefono;
	// Metodos
	public void loading_data(){
		pedirNombre();
		pedirApellidos();
		pedirNascita();
		pedirCedula();
		pedirDireccion();
		pedirTelefono();
		System.out.println("Datos guardados satisfactoriamente");
	}
	public void data_Show(){
		System.out.println("Nombre completo: "+getNombre()+" "+getApellidos());
		System.out.println("Cédula de ciudadanía: "+getCedula());
		System.out.println("Fecha de nacimiento (dd/mm/aaaa): "+fechaNacimiento[0]+"/"+fechaNacimiento[1]+"/"+fechaNacimiento[2]);
		updateEdad();
		System.out.println("Edad: "+getEdad());
		System.out.println("Dirección de residencia: "+getDireccion());
		System.out.println("Teléfono: "+getTelefono());
	}
	protected void pedirNombre(){
		System.out.print("Ingrese el nombre: ");
		String ans = teclado.nextLine();
		setNombre(ans);
	}
	protected void pedirApellidos(){
		System.out.print("Ingrese los apellidos: ");
		String ans = teclado.nextLine();
		setApellidos(ans);
	}
	protected void pedirNascita(){
		System.out.print("Ingrese la fecha de nacimiento de "+nombre+"(dd/mm/aaaa): ");
		String ans = teclado.nextLine();
		setNascita(ans);
	}
	protected void pedirCedula(){
		System.out.print("Ingrese el número de cédula de "+nombre+": ");
		String ans = teclado.nextLine();
		setCedula(ans);
	}
	protected void pedirDireccion(){
		System.out.print("Ingrese la dirección de residencia de "+nombre+": ");
		String ans = teclado.nextLine();
		setDireccion(ans);
	}
	protected void pedirTelefono(){
		System.out.print("Ingrese el número de teléfono de "+nombre+": ");
		String ans = teclado.nextLine();
		setTelefono(ans);
	}
	
	protected void setDireccion(String direccion){
		this.direccion = direccion;
	}
	public String getDireccion(){
		return direccion;
	}
	protected void setTelefono(String telefono){
		this.telefono = telefono;
	}
	public String getTelefono(){
		return telefono;
	}
	protected void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	protected void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	public String getApellidos(){
		return apellidos;
	}
	public int getEdad(){
		return edad;
	}
	protected void setNascita(String ans){
		fechaNacimiento[0] = Character.getNumericValue(ans.charAt(1))+Character.getNumericValue(ans.charAt(0))*10;
		fechaNacimiento[1] = Character.getNumericValue(ans.charAt(4))+Character.getNumericValue(ans.charAt(3))*10;
		fechaNacimiento[2] = Character.getNumericValue(ans.charAt(6))*(int)(Math.pow(10,3))+Character.getNumericValue(ans.charAt(7))*(int)(Math.pow(10,2))+Character.getNumericValue(ans.charAt(8))*(int)(Math.pow(10,1))+Character.getNumericValue(ans.charAt(9));
		updateEdad();
	}
	protected void setNascita(int yyyy, int mm, int dd){
		fechaNacimiento[0] = dd;
		fechaNacimiento[1] = mm;
		fechaNacimiento[2] = yyyy;
		updateEdad();
	}
	protected int calcularEdad(int dd, int mm, int aaaa){
		Date ahora = new Date();
		int edad = 0;
		edad = ahora.getYear()+1900 - aaaa;
		if(ahora.getMonth()+1<mm){
			edad--;
		}else if((ahora.getMonth()+1==mm)&&(ahora.getDate()<dd)){
			edad--;
		}
		return edad;
	}
	public void updateEdad(){
		edad = calcularEdad(fechaNacimiento[0],fechaNacimiento[1],fechaNacimiento[2]);
	}
	protected void setCedula(String cedula){
		this.cedula=cedula;
	}
	public String getCedula(){
		return cedula;
	}
	
}