package com.example.calc;

public class CalcModelOperation {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputString = new StringBuilder();
    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    };

    public CalcModelOperation() {
        state=State.firstArgInput;
    }

    public void onPressNumber (int buttonId){
        if (state == State.resultShow){
            state = State.firstArgInput;
            inputString.setLength(0);
        }

        if (inputString.length() < 9) {
            switch (buttonId){
                case R.id.buttonZero:
                    if (inputString.length() != 0){
                        inputString.append("0");
                    }
                    break;
                case R.id.buttonOne:
                        inputString.append("1");
                    break;
                case R.id.buttonTwo:
                    inputString.append("2");
                    break;
                case R.id.buttonThree:
                    inputString.append("3");
                    break;
                case R.id.buttonFour:
                    inputString.append("4");
                    break;
                case R.id.buttonFive:
                    inputString.append("5");
                    break;
                case R.id.buttonSix:
                    inputString.append("6");
                    break;
                case R.id.buttonSeven:
                    inputString.append("7");
                    break;
                case R.id.buttonEight:
                    inputString.append("8");
                    break;
                case R.id.buttonNine:
                    inputString.append("9");
                    break;
            }
        }
    }

    public void onPressOperation (int actionId){
        if (actionId == R.id.buttonResult && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputString.toString());
            state = State.resultShow;
            inputString.setLength(0);
            switch (actionSelected){
                case R.id.buttonPlus:
                    inputString.append(firstArg + secondArg);
                    break;
                case R.id.buttonMinus:
                    inputString.append(firstArg - secondArg);
                    break;
                case R.id.buttonMultiplication:
                    inputString.append(firstArg * secondArg);
                    break;
                case R.id.buttonDiv:
                    inputString.append(firstArg / secondArg);
                    break;
            }
        } else if  (inputString.length() >0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputString.toString());
            state = State.secondArgInput;
            inputString.setLength(0);
            switch (actionId) {
                case R.id.buttonPlus:
                    actionSelected = R.id.buttonPlus;
                    break;
                case R.id.buttonMinus:
                    actionSelected = R.id.buttonMinus;
                    break;
                case R.id.buttonMultiplication:
                    actionSelected = R.id.buttonMultiplication;
                    break;
                case R.id.buttonDiv:
                    actionSelected = R.id.buttonDiv;
                    break;
                case R.id.buttonResult:
                    actionSelected = R.id.buttonResult;
                    break;
            }
        }
    }

    public String getText () { // отображение в текстовом поле - первый, второй аргумент, результат
        return inputString.toString();
    }
}
