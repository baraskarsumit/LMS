package com.lms;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class leaveCalc {
	
	public static int calculateLeaves(LocalDate startDate, LocalDate endDate) {
		int leaves = 0;
        while (!startDate.isAfter(endDate)) {
            if (startDate.getDayOfWeek() != DayOfWeek.SATURDAY && startDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                leaves++;
            }
            startDate = startDate.plusDays(1);
        }
        return leaves;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter leave start date(dd/MM/yyyy): ");
		String start = sc.nextLine();
		System.out.print("Enter leave end date(dd/MM/yyyy): ");
		String end = sc.nextLine();
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate sd = LocalDate.parse(start,formatter);// example start date
        LocalDate ed = LocalDate.parse(end,formatter);
		int leaves = calculateLeaves(sd, ed);
		System.out.println("Total leaves: "+leaves);
	}

}
