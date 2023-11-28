/*
Milan Atanasov - 108021206887,
        Jeremy Radtke - 108021218176,
        Bekzod Amonov – 259517
        Thursday 14:00-16:00.
*/


package SE.Assignment_06;

import java.util.Scanner;

public class Main {
    private enum State{
        ON_DRONE_PAD, STAND_BY, PATH_PLANNING, FLIGHT, TRACKING, RETURN_TO_BASE, LANDING, TURNED_OFF
    }
    private static final State INITIAL_STATE = State.ON_DRONE_PAD;
    private State currentState;
    public Main(){
        currentState = INITIAL_STATE;
    }
    public void processInput(String input){

        switch (currentState){
            case ON_DRONE_PAD:
                switch (input){
                    case "turnOn":
                        currentState = State.STAND_BY;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case STAND_BY:
                switch (input){
                    case "generateRoute":
                        currentState = State.PATH_PLANNING;
                        break;
                    case "turnOff":
                        currentState = State.TURNED_OFF;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case PATH_PLANNING:
                switch (input){
                    case "abortPathPlanning":
                        currentState = State.STAND_BY;
                        break;
                    case "flyPath":
                        currentState = State.FLIGHT;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case   FLIGHT:
                switch (input){
                    case "trackingPerson":
                        currentState = State.TRACKING;
                        break;
                    case "returnToBase":
                        currentState = State.RETURN_TO_BASE;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case TRACKING:
                switch (input){
                    case "returnToBase":
                        currentState = State.RETURN_TO_BASE;
                        break;
                    case "searchMode":
                        currentState = State.FLIGHT;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case RETURN_TO_BASE:
                switch (input){
                    case "landing":
                        currentState = State.LANDING;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case LANDING:
                switch (input){
                    case "turnOff":
                        currentState = State.TURNED_OFF;
                        break;
                    default:
                        handleInvalidInput();
                }
                break;
            case TURNED_OFF:
                handleInvalidInput();
                break;
        }
        printStateAndAction();
    }
    private void handleInvalidInput(){
        System.out.println("Invalid input for the current state" + currentState);
        System.exit(1);
    }
    private void printStateAndAction(){
        System.out.println("Current State " + currentState);
        System.out.println("Events : [turnOn,trackingPerson,abortPathPlanning,flyPath,returnToBase,landing,generateRoute,turnOff]");
        System.out.println("Please enter the event : ");
    }
    public static void main(String [] args){
        Main drone = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Drone is placed");
        System.out.println("Events : [turnOn,trackingPerson,abortPathPlanning,flyPath,returnToBase,landing,generateRoute,turnOff]");
        System.out.println("Please enter event : ");
        while (true){
            String input = scanner.nextLine();
            drone.processInput(input);
        }
    }

}