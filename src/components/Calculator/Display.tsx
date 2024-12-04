import React from 'react';

type DisplayProps = {
  value: string;
  expression: string;
};

export function Display({ value, expression }: DisplayProps) {
  return (
    <div className="bg-gray-800 p-4 rounded-lg mb-4">
      <div className="text-gray-400 text-right h-6 mb-1 overflow-hidden">
        {expression || '\u00A0'}
      </div>
      <div className="text-white text-right text-3xl font-semibold truncate">
        {value || '0'}
      </div>
    </div>
  );
}