/*
 * GradeCalculator.java
 * Author: Anthony Copeland
 * Statement of Academic Honesty: *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from anywhere other than the authorized
 * sources. I recognize that any unauthorized sharing, assistance,
 * or plagiarism will be handled in accordance with both the
 * University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based on
 * an assignment created by the School of Computing
 * at the University of Georgia. Any publishing or posting
 * of source code at any time for this project is prohibited. 
 */

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		// Variables are declared.
		String wantedGrade;
		String knownScore;
		String letterGrade;
		int weightExam1;
		int weightExam2;
		int weightFinalExam;
		int weightLabs;
		int weightProjects;
		int weightParticipation;
		int weightQuizzes;
		int scoreExam1 = 0;
		int scoreExam2 = 0;
		int scoreFinalExam = 0;
		int scoreLab = 0;
		int scoreProject = 0;
		int scoreParticipation = 0;
		int scoreQuiz = 0;
		double currentScore = 0.0;
		double totalKnownGradeWeight = 0.0;
		double weightTimesScore = 0.0;
		double finalScore = 0.0;
		double avgToFinalLetterGrade = 0.0;
		
		
		System.out.println("Grading Scale:");
		System.out.println("A \t 90 - 100");
		System.out.println("B \t 80 - 89");
		System.out.println("C \t 70 - 79");
		System.out.println("D \t 60 - 69");
		System.out.println("F \t below 60");
		
		System.out.print("What letter grade do you want to achieve for the course?");
		
		wantedGrade = keyboard.nextLine().toUpperCase();
		
		//User must have a valid grade input of A, B, C, D, or F.
		if (!wantedGrade.equals("A") && !wantedGrade.equals("B") && !wantedGrade.equals("C") && !wantedGrade.equals("D") && !wantedGrade.equals("F")) {
			System.out.println("The input is invalid.");
			System.exit(0);
		}
		
		
		//User inputs weights for each grade category.
		System.out.println("Enter the percentage weights below.");
		System.out.print("Exam 1: \t");
		weightExam1 = keyboard.nextInt();
		System.out.print("Exam 2: \t");
		weightExam2 = keyboard.nextInt();
		System.out.print("Final Exam: \t");
		weightFinalExam = keyboard.nextInt();
		System.out.print("Labs: \t\t");
		weightLabs = keyboard.nextInt();
		System.out.print("Projects: \t");
		weightProjects = keyboard.nextInt();
		System.out.print("Participation: \t");
		weightParticipation = keyboard.nextInt();
		System.out.print("Quizzes: \t");
		weightQuizzes = keyboard.nextInt();
		
		if (weightExam1 + weightExam2 + weightFinalExam + weightLabs + weightProjects + weightParticipation + weightQuizzes != 100) {
			System.out.print("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}
		
		
		// Asks user for score on exam 1. 
		System.out.print("Do you know your exam 1 score?");
		knownScore = keyboard.next();
		
		if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
			System.out.print("Score received on exam 1:");
			scoreExam1 = keyboard.nextInt();
			
			// Asks user for their score on exam 2, if they know their score on exam 1.
			System.out.print("Do you know your exam 2 score?");
			knownScore = keyboard.next();
			
			if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
				System.out.print("Score received on exam 2:");
				scoreExam2 = keyboard.nextInt();
				
				// Asks user for their score on final exam, if they know their score on exam 2.
				System.out.print("Do you know your final exam score?");
				knownScore = keyboard.next();
				
				if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
					System.out.print("Score received on final exam:");
					scoreFinalExam = keyboard.nextInt();
					
				}
				else {
					weightFinalExam = 0;
				}
			}
			else {
				weightExam2 = 0;
				weightFinalExam = 0;
			}
		}
		else {
			weightExam1 = 0;
			weightExam2 = 0;
			weightFinalExam = 0;
		}
	
		
		// Asks user for their average lab grade.
		System.out.print("Do you know your lab average?");
		knownScore = keyboard.next();
		if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
			System.out.print("Average lab grade:");
			scoreLab = keyboard.nextInt();
		}
		else {
			weightLabs = 0;
		}	
		
		
		// Asks the user for their average project grade.
		System.out.print("Do you know your project average?");
		knownScore = keyboard.next();
		if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
			System.out.print("Average project grade:");
			scoreProject = keyboard.nextInt();
		}
		else {
			weightProjects = 0;
		}
		
		
		// Asks the user for their average participation grade.
		System.out.print("Do you know your participation average?");
		knownScore = keyboard.next();
		if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
			System.out.print("Average participation grade:");
			scoreParticipation = keyboard.nextInt();
		}
		else {
			weightParticipation = 0;
		}
		
		
		// Asks the user for their average quiz grade.
		System.out.print("Do you know your quiz average?");
		knownScore = keyboard.next();
		if ("Y".equalsIgnoreCase(knownScore) || "YES".equalsIgnoreCase(knownScore)) {
			System.out.print("Average quiz grade:");
			scoreQuiz = keyboard.nextInt();
		}
		else {
			weightQuizzes = 0;
		}
		
		totalKnownGradeWeight = weightExam1 + weightExam2 + weightFinalExam + weightLabs + weightProjects + weightParticipation + weightQuizzes;
		weightTimesScore = weightExam1 * scoreExam1 + weightExam2 * scoreExam2 + weightFinalExam * scoreFinalExam + weightLabs * scoreLab + weightProjects * scoreProject + weightParticipation * scoreParticipation + weightQuizzes * scoreQuiz;
		currentScore = (weightTimesScore)
				/(totalKnownGradeWeight);
		
		System.out.printf("Current grade score:%.2f", currentScore);
		System.out.println();
		
		
		// Determines the user's current letter grade based on their current score.
		if (currentScore >= 90 && currentScore <= 100) {
			letterGrade = "A";
		}
		else if (currentScore >= 80 && currentScore < 90) {
			letterGrade = "B";
		}
		else if (currentScore >= 70 && currentScore < 80) {
			letterGrade = "C";
		}
		else if (currentScore >= 60 && currentScore < 70) {
			letterGrade = "D";
		}
		else {
			letterGrade = "F";
		}
		
		System.out.println("Your current letter grade:" + letterGrade);
		
		
		// Determines the final score based on the user's wanted grade.
		if (wantedGrade.equals("A")) {
			finalScore = 90;
		}
		else if (wantedGrade.equals("B")) {
			finalScore = 80;
		}
		else if (wantedGrade.equals("C")) {
			finalScore = 70;
		}
		else if (wantedGrade.equals("D")) {
			finalScore = 60;
		}
		else if (wantedGrade.equals("F")) {
			finalScore = 0;
		}
		
		
		avgToFinalLetterGrade = (100 * finalScore - weightTimesScore) / (100 - totalKnownGradeWeight);

		
		// The user hasn't achieved their wanted grade.
		if (currentScore < finalScore && avgToFinalLetterGrade >= 0 && avgToFinalLetterGrade <= 100){
			System.out.print("In order to receive a grade of " + wantedGrade + ",\nyou need to score an average greater than \nor equal to "); 
			System.out.printf("%.2f" , avgToFinalLetterGrade); 
			System.out.print(" in the rest of the grade items.");
		    System.exit(0);
		}
		else if (avgToFinalLetterGrade > 100) {
		    System.out.println("Unfortunately, a grade of " + wantedGrade + " is not possible.");
		    System.exit(0);
		}
		 
		
		// The user has achieved their wanted grade. 
		if (totalKnownGradeWeight == 100) { // know all grades
		    System.out.println("Congratulations! You received the " + wantedGrade + " that you wanted!");
		} 
		else { // do not know all grades
		    System.out.println("You will receive at least a grade of " + wantedGrade + ".");
		}
		    
		
		keyboard.close();
		
	}

}
