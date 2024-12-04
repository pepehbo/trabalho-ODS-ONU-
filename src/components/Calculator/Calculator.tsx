import React, { useState } from 'react';
import { Button } from './Button';
import { Display } from './Display';
import { evaluateExpression, calculateSquareRoot } from './utils';

export function Calculator() {
  const [display, setDisplay] = useState('0');
  const [expression, setExpression] = useState('');
  const [newNumber, setNewNumber] = useState(true);

  const handleNumber = (num: string) => {
    if (newNumber) {
      setDisplay(num);
      setNewNumber(false);
    } else {
      setDisplay(display + num);
    }
  };

  const handleOperator = (op: string) => {
    setExpression(display + ' ' + op + ' ');
    setNewNumber(true);
  };

  const handleEquals = () => {
    const fullExpression = expression + display;
    const result = evaluateExpression(fullExpression);
    setDisplay(result);
    setExpression('');
    setNewNumber(true);
  };

  const handleSquareRoot = () => {
    const result = calculateSquareRoot(parseFloat(display));
    setDisplay(result);
    setExpression('');
    setNewNumber(true);
  };

  const handleClear = () => {
    setDisplay('0');
    setExpression('');
    setNewNumber(true);
  };

  const handleDecimal = () => {
    if (!display.includes('.')) {
      setDisplay(display + '.');
      setNewNumber(false);
    }
  };

  return (
    <div className="bg-gray-800 p-6 rounded-2xl shadow-2xl w-full max-w-xs">
      <Display value={display} expression={expression} />
      <div className="grid grid-cols-4 gap-2">
        <Button value="C" onClick={handleClear} variant="secondary" />
        <Button value="√" onClick={handleSquareRoot} variant="operator" />
        <Button value="^" onClick={() => handleOperator('^')} variant="operator" />
        <Button value="÷" onClick={() => handleOperator('÷')} variant="operator" />
        
        <Button value="7" onClick={() => handleNumber('7')} />
        <Button value="8" onClick={() => handleNumber('8')} />
        <Button value="9" onClick={() => handleNumber('9')} />
        <Button value="×" onClick={() => handleOperator('×')} variant="operator" />
        
        <Button value="4" onClick={() => handleNumber('4')} />
        <Button value="5" onClick={() => handleNumber('5')} />
        <Button value="6" onClick={() => handleNumber('6')} />
        <Button value="-" onClick={() => handleOperator('-')} variant="operator" />
        
        <Button value="1" onClick={() => handleNumber('1')} />
        <Button value="2" onClick={() => handleNumber('2')} />
        <Button value="3" onClick={() => handleNumber('3')} />
        <Button value="+" onClick={() => handleOperator('+')} variant="operator" />
        
        <Button value="0" onClick={() => handleNumber('0')} className="col-span-2" />
        <Button value="." onClick={handleDecimal} />
        <Button value="=" onClick={handleEquals} variant="operator" />
      </div>
    </div>
  );
}