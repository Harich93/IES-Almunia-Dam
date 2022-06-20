/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.app.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author beni-
 */
public class Pruebas {
    
     public static void main(String[] args) {
         
        String num = "Socket[addr=/192.168.1.129,port=61392,localport=90]";
        
        String regEx= "(?<=port=)[0-9]+(?=,)";
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(num);
        boolean result=m.find();
        System.out.println(m.group());

        
	List<String> list = new ArrayList<String>( Arrays.asList(num.split("Socket") )); 
        
        list.forEach( l -> System.err.println(l));
     }
}
