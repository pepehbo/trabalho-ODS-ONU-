import React from 'react';

type ButtonProps = {
  value: string;
  onClick: () => void;
  variant?: 'primary' | 'secondary' | 'operator';
  className?: string;
};

export function Button({ value, onClick, variant = 'primary', className = '' }: ButtonProps) {
  const baseStyles = 'h-14 rounded-lg text-lg font-medium transition-all duration-200 active:scale-95';
  const variants = {
    primary: 'bg-white text-gray-800 hover:bg-gray-100',
    secondary: 'bg-gray-200 text-gray-800 hover:bg-gray-300',
    operator: 'bg-blue-500 text-white hover:bg-blue-600',
  };

  return (
    <button
      onClick={onClick}
      className={`${baseStyles} ${variants[variant]} ${className}`}
    >
      {value}
    </button>
  );
}