export function evaluateExpression(expression: string): string {
  try {
    // Replace × with * and ÷ with /
    const sanitizedExpression = expression
      .replace(/×/g, '*')
      .replace(/÷/g, '/')
      .replace(/\^/g, '**');

    // Use Function instead of eval for better security
    const result = Function(`'use strict'; return (${sanitizedExpression})`)();
    
    // Handle decimal places
    const stringResult = Number.isInteger(result) 
      ? result.toString()
      : result.toFixed(8).replace(/\.?0+$/, '');
    
    return stringResult;
  } catch (error) {
    return 'Error';
  }
}

export function calculateSquareRoot(value: number): string {
  try {
    if (value < 0) return 'Error';
    const result = Math.sqrt(value);
    return Number.isInteger(result) 
      ? result.toString()
      : result.toFixed(8).replace(/\.?0+$/, '');
  } catch {
    return 'Error';
  }
}