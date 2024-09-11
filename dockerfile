FROM node:20-alpine

# Set working directory
WORKDIR /home

# Install dependencies
COPY package.json package-lock.json ./
RUN apk add --no-cache git curl && npm install

# Clone the repository and copy necessary files
RUN git clone https://github.com/kkmdev94/raect_study.git

# Set working directory to the project directory
WORKDIR /home/raect_study

# Copy public files to the /home/public directory
COPY public/ /home/public/

# Environment variables
ENV CHOKIDAR_USEPOLLING=true

# Expose port
EXPOSE 3000

# Start the application
CMD ["npm", "run", "start"]
#CMD ["node", "./public/index.html"]