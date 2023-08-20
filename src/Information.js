import React, { useEffect, useState } from "react";
import { View, Text, StyleSheet, ImageBackground, Image } from "react-native";
import { API_KEY } from "./Constant";
import { LinearGradient } from "expo-linear-gradient";
import { Ionicons } from "@expo/vector-icons";
import { useNavigation } from "@react-navigation/native";

const Information = ({ route }) => {
  const { name, image } = route.params;
  const [weatherData, setWeatherData] = useState(null);
  const navigation = useNavigation(); // Added the useNavigation hook

  useEffect(() => {
    const fetchWeatherData = async () => {
      try {
        const response = await fetch(
          `https://api.openweathermap.org/data/2.5/weather?q=${name}&appid=${API_KEY}`
        );
        const data = await response.json();
        setWeatherData(data);
        console.log("Weather Data:", data);
      } catch (error) {
        console.error("Error fetching weather data:", error);
      }
    };

    fetchWeatherData();
  }, []);

  return (
    <ImageBackground source={image} style={styles.backgroundImage}>
      <LinearGradient
        colors={["rgba(0, 0, 0, 0.5)", "rgba(0, 0, 0, 0.9)"]}
        style={styles.container}
      >
        <Ionicons
          style={styles.back}
          name="arrow-back"
          size={30}
          color="white"
          onPress={() => navigation.goBack()}
        />
        <Text style={styles.cityName}>{name}</Text>

        {weatherData ? (
          <View style={styles.container1}>
            <Text style={styles.temperature}>
              {Math.round(weatherData.main.temp - 273.15)}°C
            </Text>

            <View style={styles.citytype}>
              {weatherData.weather[0].main === "Clear" ? (
                <Text style={styles.WeatherInfo}>Sunny</Text>
              ) : (
                <Text style={styles.WeatherInfo}>
                  {weatherData.weather[0].main}
                </Text>
              )}

              {weatherData.weather[0].main === "Clouds" ? (
                <Image
                  style={styles.weatherImage}
                  source={require("../assets/Images/cloud.jpg")}
                />
              ) : weatherData.weather[0].main === "Clear" ? (
                <Image
                  style={styles.weatherImage}
                  source={require("../assets/Images/clear.jpg")}
                />
              ) : weatherData.weather[0].main === "Rain" ? (
                <Image
                  style={styles.weatherImage}
                  source={require("../assets/Images/rain.jpg")}
                />
              ) : (
                <Image
                  style={styles.weatherImage}
                  source={require("../assets/Images/thund.jpg")}
                />
              )}

              <Text style={styles.otherWeatherInfo}>
                Humidity: {weatherData.main.humidity}%
              </Text>
              <Text style={styles.otherWeatherInfo}>
                Pressure: {weatherData.main.pressure} hPa
              </Text>
            </View>
          </View>
        ) : null}
      </LinearGradient>
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  backgroundImage: {
    flex: 1,
    resizeMode: "cover", // Cover the entire screen
  },
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
  },
  back: {
    position: "absolute",
    top: 50,
    left: 20,
  },
  cityName: {
    fontSize: 35,
    fontWeight: "bold",
    color: "white",
    marginBottom: 40,
  },
  container1: {
    alignItems: "center",
  },
  citytype: {
    marginTop: 20,
    padding: 30,
    backgroundColor: "rgba(255, 255, 255, 0.2)",
    borderRadius: 10,
    width: 300,
    alignItems: "center",
  },
  temperature: {
    fontSize: 60,
    marginTop: 10,
    color: "white",
  },
  weatherImage: {
    width: 200,
    height: 200,
  },
  WeatherInfo: {
    fontSize: 25,
    marginTop: 5,
    textAlign: "center",
    fontWeight: "bold",
    color: "white",
  },
  otherWeatherInfo: {
    fontSize: 16,
    marginTop: 5,
    textAlign: "center",
    color: "white",
  },
});

export default Information;
