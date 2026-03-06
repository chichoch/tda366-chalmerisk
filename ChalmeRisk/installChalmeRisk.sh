#!/bin/bash

if [ -d "bin" ]; then
    echo "ALREADY INSTALLED"
    exit 0
fi

# Create a bin folder and compile the java code
mkdir -p bin
find src -name "*.java" > sources.txt
javac -d bin @sources.txt

# Copy resources and map to bin folder.
cp -r resources/* bin/
cp -r maps/* bin/

# Create the start script
cat > startChalmeRisk.sh << 'EOF'
#!/bin/bash

java -cp bin edu.chl.chalmerisk.risk.Main
EOF
chmod +x startChalmeRisk.sh

echo "ChalmeRisk Installed! Use ./startChalmeRisk.sh to start it."
