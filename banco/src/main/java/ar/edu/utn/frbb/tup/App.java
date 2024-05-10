package ar.edu.utn.frbb.tup;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        BancoMenu bancoMenu = new BancoMenu(); 
        bancoMenu.mostrarMenuPrincipal();
          
    
        scanner.close();
    }
}

