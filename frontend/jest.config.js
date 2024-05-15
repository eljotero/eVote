const nextJest = require('next/jest');
const createJestConfig = nextJest({
  dir: './',
});

const customJestConfig = {
  setupFilesAfterEnv: [require.resolve('@testing-library/jest-dom')],
  moduleDirectories: ['node_modules', '<rootDir>/'],
  testEnvironment: 'jest-environment-jsdom',
  reporters: [
    'default',
    [
      'jest-html-reporters',
      {
        publicPath: './html-report',
        filename: 'report.html',
        expand: true,
      },
    ],
  ],
};

module.exports = createJestConfig(customJestConfig, createJestConfig);
